import httpClient from './http-common';

const getVerifyEmail = (email) => {
    return httpClient.get(`http://localhost:9090/bank/verifyemail/${email}`);
  };

  const getVerifyMobile = (mobile) => {
    return httpClient.get(`http://localhost:9090/bank/verifycontact/${mobile}`);
  };


  const getAllBank = () => {
    return httpClient.get(`http://localhost:9090/bank/info`);
  };

  const getAllPendingReqBank = () => {
    return httpClient.get(`http://localhost:9090/bank/pendinginfo`);
  };

  export default { getVerifyEmail, getVerifyMobile, getAllBank, getAllPendingReqBank};