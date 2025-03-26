#!/bin/bash

if [ -f division/commit-hash.txt ]; then
  PREVIOUS_COMMIT=$(cat division/commit-hash.txt)
  CURRENT_COMMIT=${GITHUB_SHA}
  echo "Last Commit: $PREVIOUS_COMMIT"
  echo "Current Commit: $CURRENT_COMMIT"
  if [ "$PREVIOUS_COMMIT" = "$CURRENT_COMMIT" ]; then
    echo "No new commits detected. Skipping build."
    exit 0
  else
    echo "New commits detected. Proceeding with build."
  fi
else
  echo "No previous commit hash found. Proceeding with build."
fi