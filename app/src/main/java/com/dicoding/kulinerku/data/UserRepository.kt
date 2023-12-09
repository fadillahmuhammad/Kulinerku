package com.dicoding.kulinerku.data

import android.util.Log
import androidx.lifecycle.liveData
import com.dicoding.kulinerku.data.local.pref.UserModel
import com.dicoding.kulinerku.data.local.pref.UserPreference
import com.dicoding.kulinerku.data.remote.response.LoginResponse
import com.dicoding.kulinerku.data.remote.response.RegisterResponse
import com.dicoding.kulinerku.data.remote.retrofit.ApiService
import com.dicoding.kulinerku.ui.common.ResultState
import com.google.gson.Gson
import retrofit2.HttpException

class UserRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService
) {
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun loginUser(email: String, password: String): ResultState<UserModel> {
        return try {
            val successResponse = apiService.login(email, password)
            Log.d("UserRepository", "Login API response: $successResponse")
            val userModel = convertToUserModel(successResponse)
            ResultState.Success(userModel)
        } catch (e: HttpException) {
            Log.e("UserRepository", "Http error: ${e.message}")
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("UserRepository", "Error Body: $errorBody")
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            Log.e("UserRepository", "Error Response: $errorResponse")
            ResultState.Error(errorResponse.message ?: "An error occurred")
        } catch (e: Exception) {
            Log.e("UserRepository", "Exception: ${e.message}")
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

    fun registerUser(
        firtname: String,
        lastname: String,
        email: String,
        phonenumber: String,
        password: String
    ) = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse =
                apiService.register(firtname, lastname, email, phonenumber, password)
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(ResultState.Error(errorResponse.message.toString()))
        }
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