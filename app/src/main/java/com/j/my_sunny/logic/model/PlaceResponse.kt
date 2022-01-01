import com.google.gson.annotations.SerializedName
//定义返回的json数据格式
data class PlaceResponse(val status:String, val places: List<Place>)
data class Place(val name:String,val location:Location,
                 @SerializedName("formatted_address") val address:String)//@SerializedName让json字段与kotlin字段建立映射关系
data class Location(val long:String,val lat:String)