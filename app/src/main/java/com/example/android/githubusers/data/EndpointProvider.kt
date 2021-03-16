package com.example.android.githubusers.data

class EndpointProvider {
    companion object {
        var apiEndpoint: String = ""
        private const val ENDPOINT = "https://api.github.com"

        fun createEndpoint() {
            apiEndpoint = ENDPOINT
        }
    }
}
