#node block

FROM node:alpine3.18 as nodework
WORKDIR /myapp
COPY package.json .
RUN npm install
COPY . .
RUN npm run build


#node nginx
FROM nginx:1.23-alpine
WORKDIR /usr/share/nginx/html
RUN rm -rf ./*
COPY --from=nodework /myapp/build .
ENTRYPOINT [ "nginx", "-g", "daemon off;" ]
