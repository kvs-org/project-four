#!/bin/bash

curl -X POST \
  -H "Authorization: Bearer ${WORKFLOW_PAT}" \
  -H "Accept: application/vnd.github.v3+json" \
  https://api.github.com/repos/${GITHUB_REPOSITORY}/pulls \
  -d '{
    "title": "Update commit-hash.txt",
    "body": "This pull request updates the commit-hash.txt file with the latest commit hash.",
    "head": "update-commit-hash",
    "base": "main"
  }'