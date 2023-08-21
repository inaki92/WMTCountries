package com.example.inakilizarraga_walmart_countries.utils

class NullBodyException(message: String? = "Null body in response") : Exception(message)
class FailResponseException(message: String?) : Exception(message)
class NoNetworkAvailable(message: String? = "No internet connection available") : Exception(message)