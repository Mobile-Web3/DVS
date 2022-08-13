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
                    Button(
                        action: {
                            UIApplication.shared.open(URL(string: contactItem.contact.link)!)
                        },
                        label: {
                            HStack {
                                Spacer().frame(width: 2)
                                
                                Image(contactItem.contact.type)
                                    .resizable()
                                    .frame(width: 20, height: 20)
                                    .onTapGesture {
                                        UIApplication.shared.open(URL(string: contactItem.contact.link)!)
                                    }
                                
                                Text(contactItem.contact.type)
                                    .foregroundColor(Color.white)
                                
                                Spacer().frame(width: 2)
                            }
                        }
                    )
                    .padding(8)
                    .background(PurpleColor)
                    .font(Font.subheadline.weight(.bold))
                    .cornerRadius(100)
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
