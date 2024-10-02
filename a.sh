if [ ! -d ".git" ]; then
	echo "Error: This is not repository Git."
	exit 1
fi

read -p "Commit Message: " commit_message

git add .
git commit -m "$commit_message"

echo "Commited with message: $commit_message"

read -p "Enter Branch Name (default: main): " branch_name
branch_name=${branch_name:-main}

git push origin "$branch_name"

if [ $? -eq 0 ]; then
	echo "Push to branch: $branch_name"
else
	echo "Error: Push Failed."
fi