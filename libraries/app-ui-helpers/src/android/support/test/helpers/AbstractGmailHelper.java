/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.support.test.helpers;

import android.app.Instrumentation;
import android.support.test.uiautomator.Direction;

public abstract class AbstractGmailHelper extends AbstractStandardAppHelper {

    public AbstractGmailHelper(Instrumentation instr) {
        super(instr);
    }

    /**
     * Setup expectations: Gmail is open and the navigation bar is visible.
     *
     * This method will navigate to the Inbox or Primary, depending on the name.
     */
    public abstract void goToInbox();

    /**
     * Alias method for AbstractGmailHelper#goToInbox
     */
    public void goToPrimary() {
        goToInbox();
    }

    /**
     * Setup expectations: Gmail is open on the Inbox or Primary page.
     *
     * This method will open a new e-mail to compose and block until complete.
     */
    public abstract void goToComposeEmail();

    /**
     * Setup expectations: Gmail is open and on the Inbox or Primary page.
     *
     * This method will open the (index)'th visible e-mail in the list and block until the e-mail is
     * visible in the foreground. The top-most visible e-mail will always be labeled 0. To get the
     * number of visible e-mails, consult the getVisibleEmailCount() function.
     */
    public abstract void openEmailByIndex(int index);

    /**
     * Setup expectations: Gmail is open and on the Inbox or Primary page.
     *
     * This method will return the number of visible e-mails for use with the #openEmailByIndex
     * method.
     */
    public abstract int getVisibleEmailCount();

    /**
     * Setup expectations: Gmail is open and an e-mail is open in the foreground.
     *
     * This method will press reply, send a reply e-mail with the given parameters, and block until
     * the original message is in the foreground again.
     */
    public abstract void sendReplyEmail(String address, String body);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * This method will set the e-mail's To address and block until complete.
     */
    public abstract void setEmailToAddress(String address);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * This method will set the e-mail's Body and block until complete. Focus will remain on the
     * e-mail body after completion.
     */
    public abstract void setEmailBody(String body);

    /**
     * Setup expectations: Gmail is open and composing an e-mail.
     *
     * This method will get the e-mail's composition's body and block until complete.
     *
     * @return {String} the text contained in the email composition's body.
     */
    public abstract String getComposeEmailBody();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is visible.
     *
     * This method will open the navigation drawer and block until complete.
     */
    public abstract void openNavigationDrawer();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * This method will close the navigation drawer and returns true otherwise false
     */
    public abstract boolean closeNavigationDrawer();

    /**
     * Setup expectations: Gmail is open and the navigation drawer is open.
     *
     * This method will scroll the navigation drawer and block until idle. Only accepts UP and DOWN.
     */
    public abstract void scrollNavigationDrawer(Direction dir);
}
