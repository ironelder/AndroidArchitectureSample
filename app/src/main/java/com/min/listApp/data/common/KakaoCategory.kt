package com.min.listApp.data.common

enum class KakaoCategory(val category: String, val defPage: Int, val defSize: Int) {
    WEB("web", 50, 50),
    VCLIP("vclip", 15, 30),
    IMAGE("image", 50, 80),
    BLOG("blog", 1, 10),
    TIP("tip", 50, 50),
    BOOK("book", 100, 50),
    CAFE("cafe", 50, 50);

    companion object {
        fun fromString(category: String): KakaoCategory {
            return KakaoCategory.values().find { it.category == category } ?: IMAGE
        }
    }
}