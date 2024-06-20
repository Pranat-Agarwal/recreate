package com.example.recreate

import junit.framework.TestCase

class loginTest : TestCase() {
    override fun setUp() {
        super.setUp()
    }
    fun testOnCreate() {
        var exp:String="pranat"
        var ac=prin.prin()
        assertEquals(exp,ac)
    }

    override fun tearDown() {
        super.tearDown()
    }
}