//package test.netty.example.http.snoop;
//
///*
// * Copyright 2012 The Netty Project
// *
// * The Netty Project licenses this file to you under the Apache License,
// * version 2.0 (the "License"); you may not use this file except in compliance
// * with the License. You may obtain a copy of the License at:
// *
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
// * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
// * License for the specific language governing permissions and limitations
// * under the License.
// */
//
//import static org.jboss.netty.channel.Channels.*;
//
//import javax.net.ssl.SSLEngine;
//
//import org.jboss.netty.channel.ChannelPipeline;
//import org.jboss.netty.channel.ChannelPipelineFactory;
//import org.jboss.netty.example.securechat.SecureChatSslContextFactory;
//import org.jboss.netty.handler.codec.http.HttpClientCodec;
//import org.jboss.netty.handler.codec.http.HttpContentDecompressor;
//import org.jboss.netty.handler.ssl.SslHandler;
//
//public class HttpSnoopClientPipelineFactory implements ChannelPipelineFactory {
//
//    private final boolean ssl;
//
//    public HttpSnoopClientPipelineFactory(boolean ssl) {
//        this.ssl = ssl;
//    }
//
//    public ChannelPipeline getPipeline() throws Exception {
//        // Create a default pipeline implementation.
//        ChannelPipeline pipeline = pipeline();
//
//        // Enable HTTPS if necessary.
//        if (ssl) {
//            SSLEngine engine =
//                SecureChatSslContextFactory.getClientContext().createSSLEngine();
//            engine.setUseClientMode(true);
//
//            pipeline.addLast("ssl", new SslHandler(engine));
//        }
//
//        pipeline.addLast("codec", new HttpClientCodec());
//
//        // Remove the following line if you don't want automatic content decompression.
//        pipeline.addLast("inflater", new HttpContentDecompressor());
//
//        // Uncomment the following line if you don't want to handle HttpChunks.
//        //pipeline.addLast("aggregator", new HttpChunkAggregator(1048576));
//
//        pipeline.addLast("handler", new HttpSnoopClientHandler());
//        return pipeline;
//    }
//}
