# Branching Strategy

## Main Branches

- main → Production-ready code only
- develop → Integration branch for completed features

## Supporting Branches

### Feature Branch
Naming Convention:
feature/<issue-number>-short-description

Example:
feature/12-login-page

### Bugfix Branch
bugfix/<issue-number>-short-description

### Chore Branch
chore/<short-description>

## Rules

- No direct commits to main or develop
- All changes must go through Pull Requests
- Minimum 1 approval required
- CI must pass before merging
- Squash merge preferred
- Each branch must link to a GitHub Issue

## Commit Message Convention

Format:
type(scope): short description

Examples:
feat(login): implement login page object
fix(cart): resolve item removal bug
chore(ci): add github actions workflow