(ns grpc-netty.core
  (:require [aleph.http.server :as http]
            [manifold.stream :as ms])
  (:import java.lang.management.ManagementFactory
           java.lang.management.BufferPoolMXBean)
  )

(def buffers (atom []))

(defn handler [request]
  (let [{:keys [body]} request]
    @(ms/consume #(do
                    (.retain %)
                    (.retain %)
                    #_
                    (swap! buffers conj %)) body)
    {:body "hello"}))

(def server
  (http/start-server #'handler {:port 8090
                                :raw-stream? true}))

(.gc (Runtime/getRuntime))

(reset! buffers [])

(doseq [pool (ManagementFactory/getPlatformMXBeans BufferPoolMXBean)]
  (prn (.getName pool))
  (prn (.getMemoryUsed pool))
  (prn (.getTotalCapacity pool)))
