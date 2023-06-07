package com.example.part2_chap6_chatapp

class Key {  // 중요 내용(DB_URL과 같이) api_key형식으로 따로 빼내서 .gitignore에 추가하여 사용하는 것이 좋다.
    companion object {
        const val DB_URL = "https://part2-chapter6-chatapp-default-rtdb.firebaseio.com/"
        const val DB_USERS = "Users"
        const val DB_CHAT_ROOMS = "ChatRooms"
        const val DB_CHATS = "Chats"
    }
}