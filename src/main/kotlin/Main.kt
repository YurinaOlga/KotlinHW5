data class Pool (
    val id: Int,
    val ownerId: Int,
    val created: Int,
    val question: String,
    val votes: Int,
    val anonymous: Boolean,
    val multiple: Boolean
)

data class AttachmentPool (
    val pool: Pool,
    open override val type: String = "pool"
) : Attachments


data class Graffiti (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val albumId: Int
)

data class AttachmentGraffiti (
    val graffiti: Graffiti,
    open override val type: String = "graffiti"
) : Attachments

data class Document (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val albumId: Int
)

data class AttachmentDocument (
    val document: Document,
    open override val type: String = "doc"
) : Attachments


data class Audio (
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val albumId: Int
)

class AttachmentAudio (
    val audio: Audio,
    open override val type: String = "audio"
 ) : Attachments


data class Video (
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: String,
    val firstFrame: String
)


class AttachmentVideo (
    val video: Video,
    open override val type: String = "video"
) : Attachments


interface Attachments {
    val type: String
}



data class Likes (
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean)

data class Comments (
    val countComments: Int,
    val canPost: Boolean,
    val groupCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
        )

data class Copyright (
    val id: Int,
    val link: String,
    val name: String,
    val type: String
        )

data class Reposts (
    val countRepost: Int,
    val userReposted: Boolean
        )

data class Geo (
    val type: String,
    val coordinates: String,
    val place: String
        )

data class Post(
    val id: Int,
    val ownerId: Int,
    val fromID: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean,
    val comments: Comments,
    val reposts: Reposts,
    val countViews: Int,
    val copyright: Copyright,
    val postType: String,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: String,
    val canPin: Boolean,
    val canDelete: Boolean,
    val likes: Likes,
    val attachments: Array <Attachments>
)


object WallService {
    private var posts = emptyArray<Post>()

    private var lastId = 0

    fun add (post: Post): Post {
        posts += post.copy(id=  ++lastId, likes = post.likes.copy() )
        return posts.last()
    }

    fun printPosts() {
        for (post in posts){
            println(post)
        }
        println()
    }

    fun update (newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(likes = post.likes.copy())
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }
}

fun main() {

}