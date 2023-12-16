package com.dicoding.kulinerku.data

import android.util.Log
import com.dicoding.kulinerku.data.local.pref.RegisterModel
import com.dicoding.kulinerku.data.local.pref.UserModel
import com.dicoding.kulinerku.data.local.pref.UserPreference
import com.dicoding.kulinerku.data.remote.response.LoginResponse
import com.dicoding.kulinerku.data.remote.response.RegisterResponse
import com.dicoding.kulinerku.data.remote.retrofit.ApiService
import com.dicoding.kulinerku.ui.common.ResultState
import retrofit2.HttpException

class UserRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {
    private val TAG: String = "UserRepository"

    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun loginUser(email: String, password: String): ResultState<UserModel> {
        return try {
            val successResponse = apiService.login(email, password)
            Log.d(TAG, "Login API response: $successResponse")
            val userModel = convertToUserModel(successResponse)
            ResultState.Success(userModel)
        } catch (e: HttpException) {
            Log.e(TAG, "Http error: ${e.code()}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.e(TAG, "Error Body: $errorBody")

            val errorMessage = when (e.code()) {
                400 -> "Enter correct password!"
                401 -> "User is not registered, Sign Up first"
                else -> "An error occurred"
            }

            ResultState.Error(errorMessage)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}")
            ResultState.Error(e.message ?: "An error occurred")
        }
    }


    private fun convertToUserModel(response: LoginResponse): UserModel {
        val user = response.user
            ?: throw IllegalStateException("User information is missing in LoginResponse")

        return UserModel(
            message = response.message ?: "",
            email = user.email ?: "",
            token = response.token ?: "",
            isLogin = true
        )
    }

    suspend fun registerUser(
        firtname: String,
        lastname: String,
        email: String,
        phoneNumber: String,
        password: String
    ): ResultState<RegisterModel> {
        return try {
            val successResponse =
                apiService.register(firtname, lastname, email, phoneNumber, password)
            Log.d(TAG, "Login API response: $successResponse")
            val registerModel = convertToRegisterModel(successResponse)
            ResultState.Success(registerModel)
        } catch (e: HttpException) {
            Log.e(TAG, "Http error: ${e.code()}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.e(TAG, "Error Body: $errorBody")

            val errorMessage = when (e.code()) {
                400 -> "Email exists. No need to register again"
                else -> "An error occurred"
            }

            ResultState.Error(errorMessage)
        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}")
            ResultState.Error(e.message ?: "An error occurred")
        }
    }

    private fun convertToRegisterModel(response: RegisterResponse): RegisterModel {
        return RegisterModel(
            message = response.message ?: "",
            token = response.token ?: "",
        )
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }
}