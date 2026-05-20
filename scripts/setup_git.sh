#!/bin/bash
# Author: Khalid Hasan Limon
# Git Hygiene script for clean staging and pushing

git status
git add .
git commit -m "Architectural setup: Compose UI, Room, Symja, and GitHub Actions"
git push origin main
echo "Pushed successfully. Cloud compilation will begin shortly."
