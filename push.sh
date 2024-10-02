#!/bin/bash

# This script i really need because i use phone for coding this repository.

if [ ! -d ".git" ]; then
	echo "Error: This is not a Git repository."
	exit 1
fi

echo "Current git status:"
git status

if git diff-index --quiet HEAD --; then
	echo "No changes to commit."
	exit 0
fi

read -p "Commit Message: " commit_message

git add .
git commit -m "$commit_message"
echo "Commited with message: $commit_message"

read -p "Do you want to pull latest changes before pushing? (y/n): " pull_choice
if [[ "$pull_choice" =~ ^[Yy]$ ]]; then
	git pull origin "$branch_name" --rebase
fi

read -p "Enter Branch Name (default: main): " branch_name
branch_name=${branch_name:-main}

read -p "Do you want to force push? (y/n): " force_push
if [[ "$force_push" =~ ^[Yy]$ ]]; then
	git push origin "$branch_name" --force
else
	git push origin "$branch_name"
fi

if [ $? -eq 0 ]; then
	echo "Push sendded to branch: $branch_name"
else
	echo "Error: Push failed."
fi