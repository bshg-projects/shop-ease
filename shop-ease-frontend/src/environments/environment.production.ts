import {Environment} from "./ienvironment";

const host = "https://production-host"

export const environment: Environment = {
  production: true,
  apiHost: host,
  apiUrl: `${host}/api/`,
  login: `${host}/api/login`
}
