//
//  ValidatorContactsRow.swift
//  DVS
//
//  Created by Dmitrii Kuzmin on 31.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ValidatorContactsRow: View {

    var topicContacts: [Contact]

    var body: some View {
        let topicContactItems = topicContacts.map { topicContact in
            ValidatorContactItem(contact: topicContact)
        }
        
        ScrollView(.horizontal, showsIndicators: false) {
            HStack(spacing: 8) {
                ForEach(topicContactItems) { contactItem in
                    Image(contactItem.contact.type)
                        .onTapGesture {
                            UIApplication.shared.open(URL(string: contactItem.contact.link)!)
                        }
                }
            }
        }
        .padding(.top, 4)
        .padding(.bottom, 4)
    }
}

struct ValidatorContactItem: Identifiable {
    let id = UUID()
    let contact: Contact
}
