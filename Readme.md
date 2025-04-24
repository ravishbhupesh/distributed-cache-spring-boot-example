# Distributed Cache Example

## Description
This repository contains the example for distributed cache implementation for spring boot applications.

## Repository Structure
- zodiac-app
- sunsign-cache-app
- zodiac

### zodiac-app
This is a Spring Boot REST API which accepts month and date as path variables and returna JSON response containing the sunsign.

### sunsign-cache-app
This is a Spring Boot REST API which acts as a client for **zodiac-app**. This api calls the zodiac api via feign call and maintains a cache enabled by hazelcast.

### zodiac
This folder contains kubernetes configuration files.
