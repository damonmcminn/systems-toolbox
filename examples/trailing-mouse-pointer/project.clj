(defproject matthiasn/trailing-mouse-pointer "0.5.1-SNAPSHOT"
  :description "Sample application built with systems-toolbox library"
  :url "https://github.com/matthiasn/systems-toolbox"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [ch.qos.logback/logback-classic "1.1.6"]
                 [hiccup "1.0.5"]
                 [hiccup-bridge "1.0.1"]
                 [garden "1.2.5" :exclusions [org.clojure/clojure]]
                 [clj-pid "0.1.2"]
                 [matthiasn/systems-toolbox "0.5.14"]
                 [matthiasn/systems-toolbox-ui "0.5.5"]
                 [matthiasn/systems-toolbox-sente "0.5.12"]
                 [matthiasn/systems-toolbox-metrics "0.5.2"]
                 [incanter "1.5.6"]
                 [clj-time "0.11.0"]]

  :source-paths ["src/cljc/" "src/clj/"]

  :clean-targets ^{:protect false} ["resources/public/js/build/" "target/"]

  :main example.core

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.0-6"]
            [lein-codox "0.9.4"]]

  :figwheel {:server-port 3450
             :css-dirs    ["resources/public/css"]}

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljc/" "src/cljs" "env/dev/cljs"]
                        :figwheel     true
                        :compiler     {:main          "example.dev"
                                       :asset-path    "js/build"
                                       :optimizations :none
                                       :output-dir    "resources/public/js/build/"
                                       :output-to     "resources/public/js/build/example.js"
                                       :source-map    true}}
                       {:id           "release"
                        :source-paths ["src/cljc/" "src/cljs"]
                        :figwheel     true
                        :compiler     {:main          "example.core"
                                       ;:main          "example.core-mock"
                                       :asset-path    "js/build"
                                       :output-to     "resources/public/js/build/example.js"
                                       :optimizations :advanced}}]})
