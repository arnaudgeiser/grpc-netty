(defproject grpc-netty "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [aleph "0.4.6"]
                 [io.grpc/grpc-all "1.44.1"]]
  :jvm-opts ["-Dio.netty.leakDetection.level=PARANOID"
             "-XX:MaxDirectMemorySize=20m"]
  :java-source-paths ["src"]
  :repl-options {:init-ns grpc-netty.core})
