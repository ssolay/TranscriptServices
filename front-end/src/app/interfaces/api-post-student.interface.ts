export interface ApiPostStudent {
  orderHeader: {
    archiveStudent: string;
    feePathTypeAnswer: string;
    toScprofilId: string;
  };
  student: Student;
}

export interface Student {
  attendBeginYear?: string;
  attendEndYear?: string;
  attendSchoolInfo?: StudentProgram[];
  city: string;
  country: string;
  currEnrolled: string;
  dateOfBirth: string;
  degreeInfo?: StudentDegreeInfo[];
  email: string;
  firstName: string;
  lastName: string;
  middleName?: string;
  phone: string;
  schlFirstName?: string;
  schlLastName?: string;
  schlMiddleName?: string;
  ssn?: string;
  state: string;
  street1: string;
  street2?: string;
  studentId?: string;
  textMessging: {
    mobilePhoneNumber?: string;
    sendTxtMsg?: string;
  };
  updateSchoolRec: string;
  userName?: string;
  verifiedStudentId?: string;
  zip: string;
}

export interface StudentDegreeInfo {
  degreeTitle: string;
  awardYear: string;
}

export interface StudentProgram {
  attendSchool: string;
  attendSchlBeg?: string;
  attendSchlEnd?: string;
}
