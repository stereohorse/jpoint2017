#!/usr/bin/env bash


cd "$(dirname "$0")"
kill $(cat ../pid) || true
