FROM node:14-alpine AS compile-image

WORKDIR /opt/ng
COPY package.json ./

RUN npm install

ENV PATH="./node_modules/.bin:$PATH"

COPY . ./
RUN ng build -c production

FROM nginx

COPY nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=compile-image /opt/ng/dist/frontend /usr/share/nginx/html
