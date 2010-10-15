(defproject org.clojars.ohpauleez/net-ns "0.1.0-SNAPSHOT"
  :description "A remote ns system for Clojure"
  :url "http://github.com/ohpauleez/net-ns"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "See the notice in README.md or details in LICENSE.html"}
  :dependencies [;[org.clojure/clojure "1.3.0-master-SNAPSHOT"]
                 [org.clojure/clojure "1.3.0-alpha1"]
                 [aleph "0.1.1-SNAPSHOT"]]
  :dev-dependencies [[vimclojure/server "2.2.0-SNAPSHOT"]
                     ;[lein-difftest "1.3.1"]
                     ;[swank-clojure "1.3.0-SNAPSHOT"]
                     [org.clojars.ninjudd/lazytest "1.1.3-SNAPSHOT"]
                     ;[org.clojure.contrib/repl-utils "1.3.0-SNAPSHOT"]
                     [org.clojure.contrib/repl-utils "1.3.0-alpha1"]
                     [org.clojure.contrib/core "1.3.0-alpha1"]]
                     ;[lein-run "1.0.0-SNAPSHOT"]
                     ;[radagast "1.0.0"]
  ;:warn-on-reflection true
  ;:jvm-opts ["-Xmx1g"]
  :repl-init-script "script/repl_init.clj")

