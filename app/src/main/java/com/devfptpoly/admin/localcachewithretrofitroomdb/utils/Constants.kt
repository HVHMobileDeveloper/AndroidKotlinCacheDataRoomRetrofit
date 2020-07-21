package com.devfptpoly.admin.localcachewithretrofitroomdb.utils

class Constants {
    companion object {
        const val BASE_URL: String = "https://recipesapi.herokuapp.com"
        const val API_KEY: String = ""
        const val CONNECTION_TIMEOUT: Int = 10
        const val READ_TIMEOUT: Int = 2
        const val WRITE_TIMEOUT: Int = 2

        /**
         * README: 30 days (in seconds)
         */
        const val RECIPE_REFRESH_TIME: Int = 60 * 60 * 24 * 30;

        val DEFAULT_SEARCH_CATEGORIES: Array<String> = arrayOf(
            "Barbecue", "Breakfast", "Chicken", "Beef", "Brunch", "Dinner", "Wine", "Italian"
        )

        val DEFAULT_SEARCH_CATEGORY_IMAGES: Array<String> = arrayOf(
            "Barbecue",
            "breakfast",
            "chicken",
            "beef",
            "brunch",
            "dinner",
            "wine",
            "italian"
        )
    }
}