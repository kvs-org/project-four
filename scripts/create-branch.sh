#!/bin/bash

git checkout -b update-commit-hash
git config user.name "GitHub Actions"
git config user.email "actions@github.com"
git add division/commit-hash.txt
git commit -m "Update commit-hash.txt with latest commit hash"
git push origin update-commit-hash