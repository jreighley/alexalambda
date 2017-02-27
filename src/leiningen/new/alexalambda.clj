(ns leiningen.new.alexalambda
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "alexalambda"))

(defn alexalambda
  "Creates a new Alexa Skill Template for AWS lambda"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' alexalambda project.")
    (->files data
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["test/{{sanitized}}/core.cljs" (render "core_test.cljs" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)])))
