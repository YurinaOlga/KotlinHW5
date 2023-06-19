import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addIdNotNull() {
                val post = WallService.add(Post(0,2,3,124, 6,"la-la-la",54,85, true, Comments(1, true,false,true,false),Reposts(15,true),150,Copyright(1,"ur", "name", "type" ),"type", geo = null, signerId = 2, "1",true,false,Likes(15,true, false, true),AttachmentAudio(Audio(15,15,"Kl","name",150,"url",15))))

        assertTrue(post.id !=0)
    }


    @Test
    fun updateTrueId() {
        val post = WallService.add(Post(1,2,3,124, 6,"la-la-la",54,85, true, Comments(1, true,false,true,false),Reposts(15,true),150,Copyright(1,"ur", "name", "type" ),"type", geo = null, signerId = 2, "1",true,false,Likes(15,true, false, true),AttachmentAudio(Audio(15,15,"Kl","name",150,"url",15))))

        val yesUpdate =  WallService.update(Post(1,2,3,124, 6,"la-la-Bla",54,85, true, Comments(1, true,false,true,false),Reposts(15,true),150,Copyright(1,"ur", "name", "type" ),"type", geo = null, signerId = 2, "1",true,false,Likes(15,true, false, true),AttachmentAudio(Audio(15,15,"Kl","name",150,"url",15))))

        assertTrue (yesUpdate)
    }

    @Test
    fun updateFalseId() {
        val post = WallService.add(Post(1,2,3,124, 6,"la-la-la",54,85, true, Comments(1, true,false,true,false),Reposts(15,true),150,Copyright(1,"ur", "name", "type" ),"type", geo = null, signerId = 2, "1",true,false,Likes(15,true, false, true),AttachmentAudio(Audio(15,15,"Kl","name",150,"url",15))))


        val yesUpdate =  WallService.update(Post(2,2,3,124, 6,"la-la-Bla",54,85, true, Comments(1, true,false,true,false),Reposts(15,true),150,Copyright(1,"ur", "name", "type" ),"type", geo = null, signerId = 2, "1",true,false,Likes(15,true, false, true),AttachmentAudio(Audio(15,15,"Kl","name",150,"url",15))))


        assertFalse (yesUpdate)
    }
}