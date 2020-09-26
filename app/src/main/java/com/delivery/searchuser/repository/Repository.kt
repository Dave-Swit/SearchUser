package com.delivery.searchuser.repository


class Repository (
    val localApi: LocalDataSource,
    val remoteApi: RemoteDataSource
)