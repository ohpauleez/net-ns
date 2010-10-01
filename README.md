
net-ns : A remote namespace system for Clojure
==============================================

TODO: Description



Usage and Examples
==================

TODO



Installation
============

### With Leiningen

TODO

### Via Source

TODO



Hacking
=======

### Using TMUX or screen

If you want to start a new tmux server, cd to the project root dir, just type:
    script/starttmux
otherwise you can start a new session:
    tmux `cat netns.tmux.newsession`
You can also use screen:
    screen -c netns.screenrc -S net-ns


### VimClojure tips

Start a nailgun (which will also open a repl),
run the following command from the project root:
    script/nailgun

Here are helpful commands
    * \rt - run tests in the given namespace
	* \lw - lookup word
	* \li - lookup interactive
	* \gw - goto word
	* \sw - source lookup word
	* \el - eval line
	* \ep - eval paragraph
	* \me - macro expand
	* \m1 - macro expand1



License
=======

    Copyright (C) 2010 Paul deGrandis. All rights reserved.
    Distributed under the Eclipse Public License, the same as Clojure.
	
	The use and distribution terms for this software are covered by the 
	Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) 
	which can be found in the file LICENSE.html at the root of this distribution. 
	By using this software in any fashion, you are agreeing to be bound by the terms of this license. 
	You must not remove this notice, or any other, from this software.

