package com.dating.mdate.repository

import android.sdei.com.basicapp.utill.*
import com.dating.mdate.model.*
import com.google.gson.JsonElement
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface APIService {

    /**

     * @Base APIService interface :  This interface contain the all the methods
    of apis (Communicate to  servers with prdefined parameters ).
     **/

    @POST(WS_SIGNIN)
    fun loginRequestApi(@Body requestData: LoginRequest): Observable<LoginResponse>

    @POST(WS_SIGNIN_WITH_EMAIL)
    fun loginWithEmailRequestApi(@Body requestData: LoginRequest): Observable<LoginResponse>

    @POST(UPDATE_DATA)
    fun updateDataRequestApi(@Body requestData: SignUpRequest): Observable<LoginResponse>

    @POST(SOCIAL_SIGNUP)
    fun socialSignupRequestApi(@Body requestData: SignUpRequest): Observable<LoginResponse>

    @POST(SOCIAL_LOGIN)
    fun socialLoginRequestApi(@Body requestData: SignUpRequest): Observable<LoginResponse>

    @POST(VERIFY_OTP)
    fun verifyOTPRequestApi(@Body requestData: VerifyOTPRequest): Observable<LoginResponse>

    @POST(SET_PROFILE_PIC)
    fun setProfilePicRequestApi(@Body requestData: SetProfileRequest): Observable<BaseModel>

    @POST(RESEND_OTP)
    fun resendOTPRequestApi(@Body requestData: VerifyOTPRequest): Observable<VerifyOTPResponse>

    @POST(RESEND_EMAIL_OTP)
    fun resendEmailOTPRequestApi(@Body requestData: VerifyOTPRequest): Observable<VerifyOTPResponse>

    @POST(VERIFY_EMAIL)
    fun verifyEmailRequestApi(@Body requestData: VerifyEmailRequest): Observable<BaseModel>

    @POST(EDIT_PROFILE)
    fun editProfileRequestApi(@Body requestData: EditProfileRequest): Observable<LoginResponse>

    @POST(DELETE_PROFILE_PIC)
    fun deleteProfilePicRequestApi(@Body requestData: DelProfilePicRequest): Observable<LoginResponse>

    @POST(POST_CURRENT_LOC)
    fun postCurrentLocRequestApi(@Body requestData: CurrentLocRequest): Observable<BaseModel>

    @POST(GET_PROFILE_LIST)
    fun getProfileListRequestApi(@Body requestData: UserProfileRequest): Observable<UserProfileResponse>

    @POST(SEND_LIKE_REQUEST)
    fun sendLikeRequest(@Body requestData: LikeRequest): Observable<BaseModel>

    @POST(SEND_LEFT_RIGHT_REQUEST)
    fun sendLeftRightRequest(@Body requestData: LikeRequest): Observable<BaseModel>

    @POST(SEND_REPORT_REQUEST)
    fun sendReportRequest(@Body requestData: LikeRequest): Observable<BaseModel>

    @GET(GET_USER_PROFILE)
    fun getUserProfileRequestApi(@Path("id") id: String, @Path("lang") lang: String): Observable<ProfileResponse>

    @GET(GET_ETHNICITY)
    fun getEthnicityRequestApi(@Path("lang") id: String): Observable<LagngListResponse>

    @GET(GET_EDUCATION)
    fun getEducationRequestApi(@Path("lang") id: String): Observable<LagngListResponse>

    @GET(GET_LANGUAGE)
    fun getLanguageRequestApi(@Path("lang") id: String): Observable<LagngListResponse>

    @Multipart
    @POST(PHOTO_UPLOAD)
    fun uploadProfilePic(
        @Part file1: ArrayList<MultipartBody.Part>, @Part("_id") name: RequestBody, @HeaderMap headers: Map<String, String>
    ): Observable<LoginResponse>

    @Multipart
    @POST(SOCIAL_SIGNUP)
    fun uploadProfilePicSocial(
        @Part file1: ArrayList<MultipartBody.Part>, @Part("_id") name: RequestBody, @Part("firstName") firstName: RequestBody, @Part(
            "lastName"
        ) lastName: RequestBody, @Part("email") email: RequestBody, @Part("profile_motto") profile_motto: RequestBody, @Part(
            "about"
        ) about: RequestBody, @Part("gender") gender: RequestBody, @Part("dob") dob: RequestBody, @Part(
            "current_lat"
        ) current_lat: RequestBody, @Part(
            "current_lng"
        ) current_lng: RequestBody, @Part("device_type") device_type: RequestBody, @Part("userType") userType: RequestBody, @Part(
            "socialId"
        ) socialId: RequestBody, @Part("device_token") device_token: RequestBody, @HeaderMap headers: Map<String, String>
    ): Observable<LoginResponse>

    @Multipart
    @POST(EDIT_PHOTO_UPLOAD)
    fun uploadEditProfilePic(
        @Part file1: ArrayList<MultipartBody.Part>, @Part("_id") name: RequestBody, @HeaderMap headers: Map<String, String>
    ): Observable<LoginResponse>


    //Twilio Services
    @POST(GET_TOKEN)
    fun getTokenRequestApi(@Body requestData: GetTokenRequest): Observable<GetTokenResponse>

    @POST(POST_CHANNEL)
    fun channelRequestApi(@Body requestData: GetTokenRequest): Observable<ChannelResponse>

    @GET(GET_MATCHES)
    fun getMatchesListRequestApi(@Path("userId") id: String): Observable<MatchUserResponse>

    @GET(GET_CHAT)
    fun getChatListRequestApi(@Path("userId") id: String): Observable<MatchUserResponse>

    //------------------


    @FormUrlEncoded
    @POST(LOGOUT)
    fun logoutRequestApi(@Field("_id") id: String): Observable<JsonElement>

    @FormUrlEncoded
    @POST(DELETE_ACCOUNT)
    fun deleteAccountApi(@Field("userId") id: String): Observable<JsonElement>

    @GET(DEACTIVATE_ACCOUNT)
    fun deactivateAccountApi(@Path("userId") id: String): Observable<JsonElement>

    @FormUrlEncoded
    @POST(APPLY_PROMO_CODE)
    fun applyPromoCode(@Field("userId") id: String, @Field("promo_code") promo_code: String): Observable<JsonElement>

    @FormUrlEncoded
    @POST(CHANGE_PROFILE_VISIBILTY)
    fun changeProfileVisibilty(@Field("userId") id: String, @Field("visibility") visibility: String): Observable<JsonElement>

    @GET(GET_PROFILE_BY_ID)
    fun getProfileById(@Path("userId") id: String, @Path("lang") lang: String): Observable<LoginResponse>

}