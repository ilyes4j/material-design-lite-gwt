#!/bin/bash
set -e # exit with nonzero exit code if anything fails

# Automate the deployment of the demo site to github gh-pages
#whether it is for releases or for the latest snapshot

# cloning the repository into material-design-lite-gwt/target/gh-pages
git clone https://github.com/ilyes4j/material-design-lite-gwt target/gh-pages

# inside this git repo we'll indicate it is Travis that will perform the deployment
git config user.name "Travis CI"
git config user.email "ilyes.dimassi@gmail.com"

# go to the cloned repository
cd target/gh-pages

# switch to the gh-pages branch
git checkout gh-pages

# the gh-pages branch contains demos for the library
# each release should have its own demo located in a dedicated sub directory
# for example, the directory 0.1.0/ contains the demo for the 0.1.0 release

# in addition to releases, not yet released features are showcased under
# the sub directory named "snapshot"

# remove everything inside the targeted sub directory
rm -rf 'snapshot'

# copy the compilation result of the demo module into the latest sub directory
cp -r '../../material-design-lite-gwt-demo/target/material-design-lite-gwt-demo-0.1.0' 'snapshot'

# add all the changes to the index
git add --all

# commit the changes
git commit -m "Travis CI automated Deploy to GitHub Pages"

# GH_REF and GH_TOKEN are provided in the shell environment by TRAVIS CI from .travis.yml
# - GH_REF is the url for the target repository
# - GH_TOKEN is an encrypted GitHub token set by Travis CI as env variable
# the key name 'GH_TOKEN' is itself encrypted as part of the token defined by the secure
# parameter in .travis.yml
git push --quiet "https://ilyes4j:${GH_TOKEN}@${GH_REF}" gh-pages:gh-pages