FROM node:14.1-alpine AS builder

RUN npm install -g serve
COPY package.json package.json
RUN npm install
COPY . .
ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}
RUN npm run build
CMD serve -p $PORT -s dist