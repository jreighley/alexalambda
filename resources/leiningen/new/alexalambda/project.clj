(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure       "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [io.nervous/cljs-lambda    "0.3.4"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-npm       "0.6.0"]
            [lein-doo       "0.1.7"]
            [io.nervous/lein-cljs-lambda "0.6.4"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:defaults      {:role "FIXME"}
   :resource-dirs ["static"]
   :functions
   [{:name   "{{name}}-magic"
     :invoke {{name}}.core/{{name}}-magic}]}
  :cljsbuild
  {:builds [{:id "{{name}}"
             :source-paths ["src"]
             :compiler {:output-to     "target/{{sanitized}}/{{name}}.js"
                        :output-dir    "target/{{sanitized}}"
                        :source-map    "target/{{sanitized}}/{{name}}.js.map"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :advanced}}
            {:id "{{name}}-test"
             :source-paths ["src" "test"]
             :compiler {:output-to     "target/{{sanitized}}_test/{{name}}.js"
                        :output-dir    "target/{{sanitized}}_test"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :none
                        :main          {{name}}.test-runner}}]})
