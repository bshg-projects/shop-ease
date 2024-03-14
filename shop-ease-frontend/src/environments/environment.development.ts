import {Environment} from "./ienvironment";

const host = "http://localhost:8036"

export const environment: Environment = {
  production: false,
  apiHost: host,
  apiUrl: `${host}/api/`,
  login: `${host}/api/login`
}
