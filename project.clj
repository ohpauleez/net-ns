(defproject org.clojars.ohpauleez/net-ns "0.1.0-SNAPSHOT"
  :description "A remote ns system for Clojure"
  :url "http://github.com/ohpauleez/net-ns"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "See the notice in README.md or details in LICENSE.html"}
  :dependencies [[org.clojure/clojure "1.3.0-master-SNAPSHOT"]
                 [aleph "0.1.1-SNAPSHOT"]]
  :dev-dependencies [[swank-clojure "1.3.0-SNAPSHOT"]
                     [vimclojure/server "2.2.0-SNAPSHOT"]
                     ;[lein-difftest "1.2.3"]
                     [org.clojure.contrib/repl-utils "1.3.0-SNAPSHOT"]]
                     ;[lein-run "1.0.0-SNAPSHOT"]
                     ;[radagast "1.0.0"]
  ;:warn-on-reflection true
  ;:jvm-opts ["-Xmx1g"]
  :repl-init-script "script/repl_init.clj")

