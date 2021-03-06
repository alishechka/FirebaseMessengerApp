# Messenger App

Followed a Youtuber's 10 part course in building a Messenger App with Firebase\
It was quite interesting to build something that uses Realtime data from FireBase\
Not the prettiest App but very educational

[Video Stereo Link](https://www.youtube.com/watch?v=ihJGxFu2u9Q&list=PL0dzCUj1L5JE-jiBHjxlmXEkQkum_M3R- "common build that app")

- [Groupie](#Groupie)
- [CircleImageView](#CircleImageView)

### Groupie
> Groupie is a simple, flexible library for complex RecyclerView layouts.
    
Groupie includes a module for Kotlin and Kotlin Android extensions.\
Never write a ViewHolder again, Kotlin generates view references\
And Groupie uses a generic holder.

```kotlin
    val adapter = GroupAdapter<GroupieViewHolder>()

    adapter.add(UserItem(user))

class UserItem(val user: User) : Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.user_row_new_message
    }
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.username_textview_newmessage.text = user.userName
        Picasso.get().load(user.profileImageUrl).into(viewHolder.itemView.imageView_newmessage)
    }
}
```
As you see the ViewHolder is generic and you don't need all the "boiler plate code"\
Override Functions are **getLayout** and **bind**,  no need for `getItemCount`

    implementation "com.xwray:groupie:2.8.0"
[dependency resource](https://github.com/lisawray/groupie "link")


### CircleImageView
>A fast circular ImageView perfect for profile images

![](https://github.com/alishechka/FirebaseMessengerApp/blob/master/app/src/main/res/drawable/circleimage.png)


CircleImageView replaces the normal ImageView,\
also you can set border width and colour by this code
```xml
 <de.hdodenhof.circleimageview.CircleImageView
        app:civ_border_width="2dp"
        app:civ_border_color="@android:color/black"
         />
```
use this dependency

    implementation 'de.hdodenhof:circleimageview:3.1.0'
    
[dependency resource](https://github.com/hdodenhof/CircleImageView "link")
