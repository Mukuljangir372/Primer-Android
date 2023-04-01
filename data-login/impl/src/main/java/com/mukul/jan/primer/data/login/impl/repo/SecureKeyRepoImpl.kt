package com.mukul.jan.primer.data.login.impl.repo

import com.mukul.jan.primer.data.login.api.network.SecureKeyNDS
import com.mukul.jan.primer.data.login.api.repo.SecureKeyRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SecureKeyRepoImpl @Inject constructor(
    private val nds: SecureKeyNDS
) : SecureKeyRepo {
    override suspend fun generate(): Flow<String> {
        return nds.generate()
    }
}