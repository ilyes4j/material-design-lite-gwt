#!/bin/bash
set -e # exit with nonzero exit code if anything fails

# go to the out directory and create a *new* Git repo
cd material-design-lite-gwt-demo/target/material-design-lite-gwt-demo-0.1.0
# remove servlet container extra directories. These directories are not supported by github and cause the deployed app to be ignored. The previous deploy is displayed instead.
rm -rf META-INF
rm -rf WEB-INF

#create the git local repo
git init

# inside this git repo we'll indicate it is Travis that will perform the deployment
git config user.name "Travis CI"
git config user.email "ilyes.dimassi@gmail.com"

# we could have used master but for consistency make a new branch and call it gh-pages
git checkout -b gh-pages

# The first and only commit to this new Git repo contains all the
# files present with the commit message "Deploy to GitHub Pages".
git add --all
git commit -m "Travis CI automated Deploy to GitHub Pages"

# Force push from the current repo's gh-pages branch to the remote repo's gh-pages branch.
# All previous history on the gh-pages branch will be lost, since we are overwriting it.
# GH_REF and GH_TOKEN are indicated inside .travis.yml
# GH_REF is the url for the target repository
# GH_TOKEN is the encrypted Github token set as a Travis CI env variable named secure
# the key name (GH_TOKEN) is encrypted in the token itself in case you are wondering where
# is GH_TOKEN might bedefined.
git push --force --quiet "https://ilyes4j:${GH_TOKEN}@${GH_REF}" gh-pages:gh-pages
