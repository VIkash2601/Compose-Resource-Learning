package com.vikash.mycomposelearningapp.utility

import com.vikash.mycomposelearningapp.data.Message

class SampleData {
    fun conversationSample(): List<Message> {
        val messages = mutableListOf<Message>()
        for (i in 0 until 100) {
            messages.add(Message("author $i", "This is a long text message $i from the conversation"))
        }
        return messages
    }
}