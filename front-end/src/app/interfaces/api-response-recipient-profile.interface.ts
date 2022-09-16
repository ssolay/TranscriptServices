export interface ApiResponseRecipientProfile {
  exchangeNetworkType?: string;
  recipientDepartments?: ApiResponseRecipientDetails[];
  subNetwork?: ApiResponseRecipientDetails;
}

export interface ApiResponseRecipientDetails {
  deptId: number;
  deptName: string;
  ftpAccountName: string;
  fileFormat: string;
  subNetworkType?: string;
  eteIdProfiles?: {
    eteIdType: string;
    eteIdLabel: string;
    etdIdLength: number;
    etdIdFormat: string;
    etdIdGroupId: number;
  }[];
}
