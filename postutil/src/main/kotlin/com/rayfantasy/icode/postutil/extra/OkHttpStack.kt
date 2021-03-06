/*
 * Copyright 2015-2016 RayFantasy Studio
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.rayfantasy.icode.postutil.extra

import com.android.volley.toolbox.HurlStack
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.OkUrlFactory
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class OkHttpStack @JvmOverloads constructor(private val okUrlFactory: OkUrlFactory? = OkUrlFactory(OkHttpClient())) : HurlStack() {

    init {
        if (okUrlFactory == null) {
            throw NullPointerException("Client must not be null.")
        }
    }

    @Throws(IOException::class)
    override fun createConnection(url: URL): HttpURLConnection {
        return okUrlFactory!!.open(url)
    }
}
