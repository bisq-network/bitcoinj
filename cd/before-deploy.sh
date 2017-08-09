#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    # where the openssl line is the one you took note of earlier when encrypting the keys
    openssl aes-256-cbc -K $encrypted_SOME_key -iv $encrypted_SOME_iv -in cd/signingkey.asc.enc -out cd/signingkey.asc -d
    gpg --fast-import cd/signingkey.asc
fi