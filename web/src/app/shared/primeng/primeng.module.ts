import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng-lts/button';
import { CheckboxModule } from 'primeng-lts/checkbox';
import { DropdownModule } from 'primeng-lts/dropdown';
import { InputMaskModule } from 'primeng-lts/inputmask';
import { InputTextModule } from 'primeng-lts/inputtext';
import { InputTextareaModule } from 'primeng-lts/inputtextarea';
import { MessageModule } from 'primeng-lts/message';
import { MessagesModule } from 'primeng-lts/messages';
import { PanelModule } from 'primeng-lts/panel';
import { RadioButtonModule } from 'primeng-lts/radiobutton';
import { RippleModule } from 'primeng-lts/ripple';
import { TabViewModule } from 'primeng-lts/tabview';
import { ToastModule } from 'primeng-lts/toast';



const PRIMENG_COMPONENTS = [
    ButtonModule,
    InputTextModule,
    InputTextModule,
    ButtonModule,
    CheckboxModule,
    RadioButtonModule,
    PanelModule,
    DropdownModule,
    InputTextareaModule,
    RippleModule,
    TabViewModule,
    InputMaskModule,
    MessagesModule,
    MessageModule,
    ToastModule
];

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        FormsModule,
        PRIMENG_COMPONENTS
    ],
    exports: [
        PRIMENG_COMPONENTS
    ]
})
export class PrimengModule {
}
