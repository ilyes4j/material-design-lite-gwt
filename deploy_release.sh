#!/bin/bash
set -e # exit with nonzero exit code if anything fails

# Automating the deployment of the demo site to github gh-pages on project release

# cloning the repository into material-design-lite-gwt/target/gh-pages
git clone https://github.com/ilyes4j/material-design-lite-gwt target/gh-pages

# go to the cloned repository
cd target/gh-pages

# switch to the gh-pages branch
git checkout gh-pages

# the gh-pages branch contains demos for the library
# each release should have its own demo located in a dedicated sub directory
# for example, the directory X.X.X/ contains the demo for the X.X.X release

# copy the compilation result of the demo module into the latest sub directory
cp -r '../../material-design-lite-gwt-demo/target/material-design-lite-gwt-demo-0.2.0' '0.2.0'

# The first and only commit to this new Git repo contains all the
# files present with the commit message "Deploy to GitHub Pages".

# add all the changes to the index
git add --all

# commit the changes
git commit -m "Deploying the demo for Release 0.2.0 to GitHub Pages"

git push --quiet origin gh-pages