import httpClient from './http-common';

const getVerifyEmail = (email) => {
    return httpClient.get(`http://localhost:9090/bank/verifyemail/${email}`);
  };

  const getVerifyMobile = (mobile) => {
    return httpClient.get(`http://localhost:9090/bank/verifycontact/${mobile}`);
  };

  export default { getVerifyEmail, getVerifyMobile};