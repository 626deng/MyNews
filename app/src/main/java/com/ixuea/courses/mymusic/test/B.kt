package com.ixuea.courses.mymusic.test

class B {

    val a = A()
    fun Bb() {
        a.getMyTes(object : myTest {
            override fun onSuccess() {
                TODO("Not yet implemented")
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }

        })
        object : myTest {
            override fun onSuccess() {
                TODO("Not yet implemented")
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }


        }

    }
}