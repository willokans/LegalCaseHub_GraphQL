package com.wyloks.legalcasehub.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "legal_cases")
public class LegalCase {
    @Id
    private String id;
    private Long caseNumber;
    private String caseType;
    private String caseStatus;
    private String courtName;
    private String judgeName;
    private Date filingDate;
    private Date hearingDate;
    private String caseDescription;
    private String plaintiffName;
    private String defendantName;
    private String attorneyName;
    private String attorneyContact;
    private String caseOutcome;
    private String caseNotes;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;
    private String caseDocuments;
    private String caseHistory;
    private String caseRelatedParties;
    private String caseRelatedCases;
    private String caseRelatedDocuments;
    private String caseRelatedNotes;
    private String caseRelatedTasks;
    private String caseRelatedEvents;
    private String caseRelatedContacts;
    private String caseRelatedEmails;
    private String caseRelatedMessages;
    private String caseRelatedReminders;
    private String caseRelatedNotifications;
    private String caseRelatedAlerts;
    private List<String> keywords;
    private String fullText;
    private String casePriority;
    private String caseCategory;
    private String caseSubCategory;
    private String caseJurisdiction;
    private String caseLocation;
    private String caseLanguage;
    private String caseConfidentiality;
    private String caseSecurityLevel;
    private String caseAccessLevel;
    private String caseAccessControl;
    private String caseAccessHistory;
    private String caseAccessLogs;
    private String caseAccessRequests;
    private String caseAccessApproval;
    private String caseAccessDenial;
    private String caseAccessRevocation;
    private boolean isPublic;
    private boolean isConfidential;
    private boolean isArchived;
    private boolean isActive;
    private boolean isClosed;
}
